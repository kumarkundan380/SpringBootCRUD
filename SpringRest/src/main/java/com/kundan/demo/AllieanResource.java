package com.kundan.demo;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllieanResource {
	
	@RequestMapping("allien")
	public List<Allien> getAllien()
	{
		Allien a1=new Allien();
		List<Allien> allien=new ArrayList<>();
		
		a1.setAid(101);
		a1.setAname("Kundan Kumar");
		a1.setPoint(800);
		
		Allien a2=new Allien();
		a2.setAid(102);
		a2.setAname("Kundan Kumar");
		a2.setPoint(800);
		
		Allien a3=new Allien();
		a3.setAid(103);
		a3.setAname("Kundan Kumar");
		a3.setPoint(800);
		
		allien.add(a1);
		allien.add(a2);
		allien.add(a3);
		
		return allien;
	}

}
