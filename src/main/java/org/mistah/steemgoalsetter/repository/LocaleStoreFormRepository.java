package org.mistah.steemgoalsetter.repository;

import java.util.Date;
import java.util.List;

import org.mistah.steemgoalsetter.enumeration.FormStatus;
import org.mistah.steemgoalsetter.enumeration.FormType;
import org.mistah.steemgoalsetter.model.admin.form.LocaleStoreForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleStoreFormRepository extends MongoRepository<LocaleStoreForm, String> {
    List<LocaleStoreForm> findAllByOrderByTransactionDate();

    List<LocaleStoreForm> findByLocaleAndFormTypeAndStatusOrderByTransactionDateDesc(String locale, FormType order,
            FormStatus confirmed);

    List<LocaleStoreForm> findByFormTypeAndStatusAndTransactionDateLessThan(FormType order, FormStatus confirmed,
            Date stagnantDate);
}