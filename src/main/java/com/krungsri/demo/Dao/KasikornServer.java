package com.krungsri.demo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.krungsri.demo.Bean.KrungsriPriceBean;
import com.krungsri.demo.DB.ConnectDB;

@Repository
public class KasikornServer {

	
	// krungsri_price
				public KrungsriPriceBean checkpriceKa(String carYear, String carMake2) throws SQLException {
					KrungsriPriceBean kabean = new KrungsriPriceBean();
					ConnectDB con = new ConnectDB();
					PreparedStatement prepared = null;
					StringBuilder sql = new StringBuilder();
					Connection conn = con.openConnect();

					try {
						sql.append(" SELECT * FROM krungsri_price WHERE  ye_year= ? and br_name= ? ");
						prepared = conn.prepareStatement(sql.toString());
						prepared.setString(1, carYear);
						prepared.setString(2, carMake2);
						ResultSet rs = prepared.executeQuery();
						while (rs.next()) {
							kabean.setKrPrice(rs.getString("kr_price"));
							
						}
					} catch (Exception e) {

						// TODO: handle exception
					}
					finally {
						conn.close();
					}


					return kabean;
				}
}
