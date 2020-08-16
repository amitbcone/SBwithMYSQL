package com.amit.sbmysql.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class AlterDatabase
{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addColumn(String tabName, String columnName, String datatype, String afterColumn)
    {
        String alterQuery = "Alter Table " + tabName + " Add column " + columnName + " " + datatype + " After " + afterColumn;
        System.out.println("alterQuery:::: " + alterQuery);
        execute(alterQuery);
    }

    @Transactional
    public void createTempTable()
    {
        System.out.println("inside create temp table..." + entityManager);
        execute("Create table TEMP_TABLE_TEST select * FROM MIGRATE_TEST");
    }

    private void execute(String alterQuery)
    {
        entityManager.createNativeQuery(alterQuery).executeUpdate();
    }

}
