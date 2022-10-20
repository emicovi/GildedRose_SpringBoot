package com.gildedrose.GildedRose;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GildedRoseApplicationTests {

	@Test
	void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose();
		app.updateInventory(items);
		assertEquals("foo", app.itemFactory.getInventoryItem(items[0]).getName(items[0]));
	}

	@Test
	void standardItem_quality_decreases_sellIn_decreases_each_day() {
		int startingSellin = 5;
		int startingQuality = 7;
		final Item standardItem = new Item("Elixir of the Mongoose", startingSellin, startingQuality);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] {standardItem});

		assertThat(standardItem.sellIn).isEqualTo(startingSellin - 1);
		assertThat(standardItem.quality).isEqualTo(startingQuality - 1);
	}

	@Test
	void item_quality_is_never_negative() {
		Item item = new Item("First Standard Item", 4, 0);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isZero();
		assertThat(item.sellIn).isEqualTo(3);
	}

	@Test
	void item_quality_degrades_down_to_zero() {
		Item item = new Item("First Standard Item", 4, 1);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isZero();
		assertThat(item.sellIn).isEqualTo(3);
	}

	@Test
	void quality_of_an_item_is_never_more_than_50() {
		Item item = new Item("Aged Brie", 2, 50);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(50);
	}

	@Test
	void aged_items_increase_in_quality_as_they_get_older() {
		Item item = new Item("Aged Brie", 2, 0);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(1);
	}

	@Test
	void aged_items_increase_in_quality_twice_as_fast_after_sell_by_date() {
		Item item = new Item("Aged Brie", 0, 0);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(2);
	}

	@Test
	void aged_items_increase_in_quality_twice_as_fast_after_sell_by_date_but_never_more_than_50() {
		Item item = new Item("Aged Brie", 0, 49);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(50);
	}

	@Test
	void item_quality_degrades_by_1_with_1_day_left() {
		Item item = new Item("First Standard Item", 1, 10);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(9);
	}

	@Test
	void quality_degradation_doubles_after_sellIn_date() {
		Item item = new Item("First Standard Item", 0, 10);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(8);
	}

	@Test
		void legendary_items_never_decrease_in_quality_or_sellIn() {
			Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
			GildedRose subject = new GildedRose();

			subject.updateInventory(new Item[] { item });

			assertThat(item.quality).isEqualTo(80);
			assertThat(item.sellIn).isEqualTo(0);
	}

	@Test
	void backstage_passes_increase_in_quality_as_sellIn_approaches() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(21);
	}

	@Test
	void backstage_passes_increase_in_quality_by_2_when_sellIn_is_10_or_less() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(22);
	}


	@Test
	void backstage_passes_increase_in_quality_by_3_when_sellIn_is_5_or_less() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(23);
	}

	@Test
	void backstage_passes_quality_drops_to_0_after_concert() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(0);
	}

	@Test
	void aged_quality_never_exceeds_50() {
		Item item = new Item("Aged Brie", 2, 50);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(50);
	}



	@Test
	void multiple_items_degrade_each_day() {
		Item item1 = new Item("First Standard Item", 4, 10);
		Item item2 = new Item("Second Standard Item", 2, 5);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item1, item2 });

		assertThat(item1.quality).isEqualTo(9);
		assertThat(item1.sellIn).isEqualTo(3);
		assertThat(item2.quality).isEqualTo(4);
		assertThat(item2.sellIn).isEqualTo(1);
	}


	@Test
	void conjured_items_degrade_twice_as_fast() {
		Item item = new Item("Conjured Mana Cake", 3, 6);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(4);
		assertThat(item.sellIn).isEqualTo(2);
	}

	@Test
	void conjured_items_degrade_twice_as_fast_after_sell_by_date() {
		Item item = new Item("Conjured Mana Cake", 0, 6);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(2);
	}

	@Test
	void conjured_items_can_never_have_negative_quality() {
		Item item = new Item("Conjured Mana Cake", 0, 1);
		GildedRose subject = new GildedRose();

		subject.updateInventory(new Item[] { item });

		assertThat(item.quality).isEqualTo(0);
	}

}
