package com.example.serverless;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.example.serverless.beans.Item;

@Component
public class ItemInfo implements Function<Item, String> {

	@Override
	public String apply(Item item) {
		return item.toString();
	}

}
