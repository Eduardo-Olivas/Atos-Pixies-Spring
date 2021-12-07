package com.atos.campus.pixies.trainingmanagementsystem.model;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.boot.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class StringIdGenerator extends SequenceStyleGenerator {

    public static final String PREFIX = "valuePrefix";
    public static final String PREFIX_DEFAULT = "";
    private String valuePrefix;

    public static final String NUMBER_FORMAT = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%d";
    private String numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return valuePrefix + String.format(numberFormat, super.generate(session, object));
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        valuePrefix = ConfigurationHelper.getString(PREFIX, params, PREFIX_DEFAULT);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT, params, NUMBER_FORMAT_DEFAULT);
    }

}