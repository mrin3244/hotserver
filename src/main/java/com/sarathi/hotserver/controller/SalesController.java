package com.sarathi.hotserver.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarathi.hotserver.HotserverApplication;
import com.sarathi.hotserver.bean.SalesEntryBean;
import com.sarathi.hotserver.repo.CategoryRepo;
import com.sarathi.hotserver.repo.ItemRepo;
import com.sarathi.hotserver.repo.TodaysSaleRepo;

@RestController
public class SalesController {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private TodaysSaleRepo saleRepo;
	
	@PostMapping("/getMenuAndCategoryList")
	public Object getMenuAndCategoryList(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("itemList", itemRepo.findAll());
		map.put("categoryList", categoryRepo.findAll());
		return map;
	}
	
	@PostMapping("/salesEntry")
	public Object salesEntry(SalesEntryBean entryBean) {
		/*HashMap<String, Object> map = new HashMap<>();
		String msg = "";
		Optional<Items> item = itemRepo.findById(menuId);
		if(item.isPresent()) {
			TodaysSale sale = new TodaysSale(
					menuId, quantity, item.get().getPrice() * quantity, "9674443244", new Date());
			try {
				saleRepo.save(sale);
				msg = "success";
			} catch (Exception e) {
				e.printStackTrace()
				msg = "Unable to save sales detail...!!";
			}
		} else {
			msg = "Item not found...!!";
		}
		map.put("msg", msg);*/
		return entryBean;
	}
	
	public static void main(String[] args) {
		System.out.println("--------partitioningBy-------------");
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		Map<Boolean, List<Integer>> result = numbers.stream()
				.collect(Collectors.partitioningBy(e -> e%2==0));
		Map<Boolean, List<Integer>> result1 = numbers.stream()
				.collect(Collectors.partitioningBy(e-> e>3));
		System.out.println(result);
		System.out.println("--------counting-------------");
		long count = numbers.stream()
				.collect(Collectors.counting());
		System.out.println(count);
		System.out.println("--------summarizingInt-------------");
		IntSummaryStatistics stats = numbers.stream()
				.collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println(stats);
		System.out.println("--------mapping-------------");
		List<String> words = Arrays.asList("Apple", "Banana", "Cherry");
		List<Integer> lengths = words.stream()
				.collect(Collectors.mapping(String::length, Collectors.toList()));
		System.out.println(lengths);
		System.out.println("--------joining-------------");
		String fullString = words.stream()
				.collect(Collectors.joining(",", "{", "}"));
		System.out.println(fullString);
		System.out.println("--------groupingBy-------------");
		Map<Integer, Long> groupByLength = words.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(groupByLength);
		System.out.println("--------filtering-------------");
		List<Integer> evenList = numbers.stream()
				.collect(Collectors.filtering(n->n%2==0, Collectors.toList()));
		System.out.println(evenList);
	}
}
	