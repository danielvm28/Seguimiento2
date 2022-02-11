package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecipeTest {
	
	//State
	private Recipe recipe;
	
	//Scenarios
	public void setupStage1() {
		recipe = new Recipe();
	}
	
	public void setupStage2() {
		recipe = new Recipe();
		recipe.addIngredient("Cebolla", 315);
		recipe.addIngredient("Ajo", 58);
		recipe.addIngredient("Arroz", 520);
	}
	
	@Test
	void newIngredientTest() {
		setupStage1();
		String n = "Sal";
		double w = 12;
		
		recipe.addIngredient(n, w);
		
		assertEquals(1, recipe.getIngredients().size());
		
		Ingredient newIngredient = recipe.getIngredients().get(0);
		assertEquals(newIngredient.getName(), n);
		assertEquals(newIngredient.getWeight(), w);
	}
	
	@Test
	void addedIngredientTest() {
		setupStage2();
		String n = "Pimienta";
		double w = 6;
		
		recipe.addIngredient(n, w);
		
		assertEquals(4, recipe.getIngredients().size());
		
		Ingredient newIngredient = recipe.getIngredients().get(3);
		assertEquals(newIngredient.getName(), n);
		assertEquals(newIngredient.getWeight(), w);
	}
	
	@Test
	void updateIngredientWeightTest() {
		setupStage2();
		String n = "Ajo";
		double w = 21;
		
		recipe.addIngredient(n, w);
		
		assertEquals(3, recipe.getIngredients().size());
		
		Ingredient existentIngredient = recipe.getIngredients().get(1);
		assertEquals(existentIngredient.getName(), n);
		assertEquals(existentIngredient.getWeight(), 79);
	}
	
	@Test
	void removeIngredientTest() {
		setupStage2();
		String n = "Ajo";
		
		recipe.removeIngredient(n);
		
		assertEquals(2, recipe.getIngredients().size());
		
		Ingredient existentIngredient1 = recipe.getIngredients().get(0);
		Ingredient existentIngredient2 = recipe.getIngredients().get(1);
		
		assertEquals(existentIngredient1.getName(), "Cebolla");
		assertEquals(existentIngredient2.getName(), "Arroz");
	}

}
