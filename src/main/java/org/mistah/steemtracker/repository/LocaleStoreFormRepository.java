package org.mistah.steemtracker.repository;

import java.util.Date;
import java.util.List;

import org.mistah.steemtracker.enumeration.FormStatus;
import org.mistah.steemtracker.enumeration.FormType;
import org.mistah.steemtracker.model.admin.form.LocaleStoreForm;
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