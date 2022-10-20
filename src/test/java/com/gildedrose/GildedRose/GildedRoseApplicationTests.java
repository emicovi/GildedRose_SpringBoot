package com.gildedrose.GildedRose;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GildedRoseApplicationTests {

	@Autowired
	private GildedRose gildedRose;

	public GildedRose getGildedRose() {
		return gildedRose;
	}

	@Test
	void standardItem_quality_decreases_sellIn_decreases_each_day() {
		int startingSellin = 5;
		int startingQuality = 7;
		Item [] items = new Item[] { new Item("Elixir of the Mongoose", startingSellin, startingQuality) };

		gildedRose.updateInventory(items);

		assertThat(items[0].sellIn).isEqualTo(startingSellin - 1);
		assertThat(items[0].quality).isEqualTo(startingQuality - 1);


	}


	@Test
	void item_quality_is_never_negative() {
		Item [] items = new Item[] { new Item("First Standard Item", 4, 0) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isZero();
		assertThat(items[0].sellIn).isEqualTo(3);
	}

	@Test
	void item_quality_degrades_down_to_zero() {
		Item [] items = new Item[] { new Item("First Standard Item", 4, 1) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isZero();
		assertThat(items[0].sellIn).isEqualTo(3);
	}

	@Test
	void quality_of_an_item_is_never_more_than_50() {
		Item [] items = new Item[] { new Item("Aged Brie", 2, 50) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(50);
	}

	@Test
	void aged_items_increase_in_quality_as_they_get_older() {
		Item [] items = new Item[] { new Item("Aged Brie", 2, 0) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(1);
	}

	@Test
	void aged_items_increase_in_quality_twice_as_fast_after_sell_by_date() {
		Item [] items = new Item[] { new Item("Aged Brie", 0, 0) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(2);
	}

	@Test
	void aged_items_increase_in_quality_twice_as_fast_after_sell_by_date_but_never_more_than_50() {
		Item [] items = new Item[] { new Item("Aged Brie", 0, 49) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(50);
	}

	@Test
	void item_quality_degrades_by_1_with_1_day_left() {
		Item [] items = new Item[] { new Item("First Standard Item", 1, 10) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(9);
	}

	@Test
	void quality_degradation_doubles_after_sellIn_date() {
		Item [] items = new Item[] { new Item("First Standard Item", 0, 10) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(8);
	}

	@Test
		void legendary_items_never_decrease_in_quality() {
		Item [] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(80);

	}

	@Test
	void backstage_passes_increase_in_quality_as_sellIn_approaches() {
		Item [] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(21);
	}

	@Test
	void backstage_passes_increase_in_quality_by_2_when_sellIn_is_10_or_less() {
		Item [] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(22);
	}


	@Test
	void backstage_passes_increase_in_quality_by_3_when_sellIn_is_5_or_less() {
		Item [] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(23);
	}

	@Test
	void backstage_passes_quality_drops_to_0_after_concert() {
		Item [] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(0);
	}

	@Test
	void aged_quality_never_exceeds_50() {
		Item [] items = new Item[] { new Item("Aged Brie", 2, 50) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(50);
	}



	@Test
	void multiple_items_degrade_each_day() {
		Item [] items = new Item[] { new Item("First Standard Item", 4, 10), new Item("Second Standard Item", 3, 5) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(9);
		assertThat(items[0].sellIn).isEqualTo(3);
		assertThat(items[1].quality).isEqualTo(4);
		assertThat(items[1].sellIn).isEqualTo(2);
	}

	@Test
	void conjured_items_degrade_twice_as_fast_after_sell_by_date() {
		Item [] items = new Item[] {(new Item("Conjured", 0, 6))};

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(2);
		assertThat(items[0].sellIn).isEqualTo(-1);
	}


	@Test
	void conjured_items_degrade_twice_as_fast() {
		Item [] items = new Item[]{(new Item("Conjured", 3, 6))};

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isEqualTo(4);
		assertThat(items[0].sellIn).isEqualTo(2);
	}



	@Test
	void conjured_items_can_never_have_negative_quality() {
		Item [] items = new Item[] { new Item("Conjured", 0, 1) };

		gildedRose.updateInventory(items);

		assertThat(items[0].quality).isZero();
		assertThat(items[0].sellIn).isEqualTo(-1);
	}
}
