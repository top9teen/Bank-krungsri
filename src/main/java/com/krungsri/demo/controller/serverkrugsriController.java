package com.krungsri.demo.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.krungsri.demo.Bean.MiradoBean;
import com.krungsri.demo.Bean.KrungsriPriceBean;
import com.krungsri.demo.Dao.KasikornServer;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class serverkrugsriController {

	
		@Autowired
		KasikornServer kasikornServer;

		@RequestMapping(value="/kr" , method = RequestMethod.POST)
		public KrungsriPriceBean kars(@RequestBody MiradoBean miradoBean) throws SQLException {
			KrungsriPriceBean ff = new KrungsriPriceBean();

			String a = miradoBean.getGroupType();
			String b = miradoBean.getCarMake2();
			ff = kasikornServer.checkpriceKa(a, b);
			return ff;
		}
}
//end class	

