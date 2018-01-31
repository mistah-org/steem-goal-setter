package org.mistah.steemgoalsetter.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.base.models.AccountName;
import eu.bittrade.libs.steemj.base.models.AppliedOperation;
import eu.bittrade.libs.steemj.configuration.SteemJConfig;
import eu.bittrade.libs.steemj.enums.PrivateKeyType;
import eu.bittrade.libs.steemj.exceptions.SteemCommunicationException;
import eu.bittrade.libs.steemj.exceptions.SteemResponseException;

@Controller
public class PostsController {

	final Logger logger = LoggerFactory.getLogger(PostsController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// true passed to CustomDateEditor constructor means convert empty
		// String to null
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new MultiDateFormat(), true));
	}

	/**
	 * Retrieve the book with the specified id.
	 */
	@RequestMapping(value = "/{username}/posts", method = RequestMethod.GET)
	public String show(@PathVariable("username") String username, Model model) {
		return "account/posts";
	}

	/**
	 * Retrieve the book with the specified id.
	 *
	 * @throws SteemResponseException
	 * @throws SteemCommunicationException
	 */
	@RequestMapping(value = "/{username}/posts", method = RequestMethod.POST)
	public String update(@PathVariable("username") String username,
			@RequestParam(value = "startDate", required = false) Date fromDate,
			@RequestParam(value = "endDate", required = false) Date toDate, Model model)
			throws SteemCommunicationException, SteemResponseException {
		logger.info("from: " + fromDate);
		logger.info("to: " + toDate);

		SteemJConfig myConfig = SteemJConfig.getInstance();
		myConfig.setDefaultAccount(new AccountName("steemj"));

		// Add and manage private keys:
        List<ImmutablePair<PrivateKeyType, String>> privateKeys = new ArrayList<>();
        privateKeys.add(new ImmutablePair<>(PrivateKeyType.POSTING, "PRIVATE KEY"));
        // ... add more keys if needed.

        myConfig.getPrivateKeyStorage().addAccount(myConfig.getDefaultAccount(), privateKeys);

		myConfig.setEndpointURIs(new ArrayList<Pair<URI, Boolean>>());

		try {
			ArrayList<Pair<URI, Boolean>> endpoints = new ArrayList<>();

			ImmutablePair<URI, Boolean> webSocketEndpointZero = new ImmutablePair<>(new URI("https://api.steemit.com"),
					true);
			ImmutablePair<URI, Boolean> webSocketEndpointOne = new ImmutablePair<>(new URI("wss://steemd.steemit.com"),
					true);
			ImmutablePair<URI, Boolean> webSocketEndpointTwo = new ImmutablePair<>(new URI("wss://seed.bitcoiner.me"),
					true);
			ImmutablePair<URI, Boolean> webSocketEndpointThree = new ImmutablePair<>(
					new URI("wss://steemd.minnowsupportproject.org"), true);

			endpoints.add(webSocketEndpointZero);
			endpoints.add(webSocketEndpointOne);
			endpoints.add(webSocketEndpointTwo);
			endpoints.add(webSocketEndpointThree);

			myConfig.setEndpointURIs(endpoints);
		} catch (URISyntaxException e) {
			throw new RuntimeException("The given URI is not valid.", e);
		}

		SteemJ steemJ = new SteemJ();

		Map<Integer, AppliedOperation> accountHistory = steemJ.getAccountHistory(new AccountName("steemj"), 0, 100);
		for (Integer key : accountHistory.keySet()) {
			AppliedOperation appliedOperation = accountHistory.get(key);
			logger.info("{} made a {} operation.", "steemj", appliedOperation.getOp());
		}

		return "account/followers";
	}

}
