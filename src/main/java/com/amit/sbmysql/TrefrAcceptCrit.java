package com.amit.sbmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amit.sbmysql.repositories.AlterDatabase;

@Component
public class TrefrAcceptCrit {
	
@Autowired
AlterDatabase alterDB;

public void exec() {
	
	try {
	System.out.println("Altering table...");
	alterDB.createTempTable();
	alterDB.addColumn("TEMP_TABLE_TEST", "EFFECTIVEDATE", "VARCHAR(255)", "VEHCAT");
	alterDB.addColumn("TEMP_TABLE_TEST", "CHANGETIMESTAMP", "VARCHAR(255)", "EFFECTIVEDATE");
	alterDB.addColumn("TEMP_TABLE_TEST", "EFFECTIVEENDDATE", "VARCHAR(255)", "CHANGETIMESTAMP");
	alterDB.addColumn("TEMP_TABLE_TEST", "ENDDATETIMESTAMP", "VARCHAR(255)", "EFFECTIVEENDDATE");
	}catch(Exception e) {
		e.printStackTrace();
	}
}

}
