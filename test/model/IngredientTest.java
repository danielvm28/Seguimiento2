package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.NegativeNumberException;

class IngredientTest {
	
	//State
	private Ingredient ingredient;
	
	//Scenarios
	public void setupStage1() {
		ingredient = new Ingredient("Tomate", 245);
	}
	
	//Tests
	@Test
	void updateWeightTest() {
		setupStage1();
		double weight = 54;
		
		try {
			ingredient.addWeight(weight);
		} catch (NegativeNumberException e) {
			e.printStackTrace();
		}
		
		assertEquals(299, ingredient.getWeight());
	}
	
	@Test
	void negativeWeightTest() {
		setupStage1();
		double weight = -100;
		
		assertThrows(NegativeNumberException.class, () -> {
			ingredient.addWeight(weight);
		});
		
		assertEquals(245, ingredient.getWeight());
	}
	
	@Test
	void removeWeightTest() {
		setupStage1();
		double weight = 45;
		
		try {
			ingredient.removeWeight(weight);
		} catch (NegativeNumberException e) {
			e.printStackTrace();
		}
		
		assertEquals(200, ingredient.getWeight());
	}
	
	@Test
	void removeNegativeWeightTest() {
		setupStage1();
		double weight = -100;
		
		assertThrows(NegativeNumberException.class, () -> {
			ingredient.removeWeight(weight);
		});
		
		assertEquals(245, ingredient.getWeight());
	}

}
