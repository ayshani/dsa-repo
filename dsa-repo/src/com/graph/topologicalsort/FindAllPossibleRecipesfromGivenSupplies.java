package com.graph.topologicalsort;

import java.util.*;

/*
2115. Find All Possible Recipes from Given Supplies

You have information about n different recipes.
You are given a string array recipes and a 2D string array ingredients.
The ith recipe has the name recipes[i], and you can create it if you have all the needed
ingredients from ingredients[i]. Ingredients to a recipe may need to be created from other recipes,
i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have,
and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.



Example 1:

Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
Output: ["bread"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".

Example 3:

Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],
                 ["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich","burger"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".

Logic
------
For each recipe, count its non-available ingredients as in degree;
Store (non-available ingredient, dependent recipes) as HashMap;
Store all 0-in-degree recipes into a list as the starting points of topological sort;
Use topogical sort to decrease the in degree of recipes, whenever the in-degree reaches 0, add it to return list.
 */
public class FindAllPossibleRecipesfromGivenSupplies {

    public static void main(String[] args) {
        String[] recipes = new String[]{"bread","sandwich","burger"};
        String[] supplies = new String[]{"yeast","flour","meat"};
        List<List<String>> ingredients  = new ArrayList<>();
        for(int i=0;i<3;i++){
            ingredients.add(new ArrayList<>());
        }
        ingredients.get(0).add("yeast");
        ingredients.get(0).add("flour");
        ingredients.get(1).add("bread");
        ingredients.get(1).add("meat");
        ingredients.get(2).add("sandwich");
        ingredients.get(2).add("bread");
        ingredients.get(2).add("meat");

        System.out.println(new FindAllPossibleRecipesfromGivenSupplies().findAllRecipes(recipes,ingredients,supplies));

    }
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> answer = new ArrayList<>();

        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        Map<String,Integer> inDegree = new HashMap<>();
        Map<String, Set<String>> ingredientToRecipes = new HashMap<>();

        for(int i=0;i< recipes.length;i++){
            int notAvailableIngredient =0;
            for(String ingredient : ingredients.get(i)){
                if(!available.contains(ingredient)){
                    ingredientToRecipes.computeIfAbsent(ingredient, s-> new HashSet<>()).add(recipes[i]);
                    notAvailableIngredient++;
                }
            }

            if(notAvailableIngredient==0){
                answer.add(recipes[i]);
            } else{
                inDegree.put(recipes[i],notAvailableIngredient);
            }
        }

        for(int i=0;i<answer.size();i++){
            String recipe = answer.get(i);

            if(ingredientToRecipes.containsKey(recipe)){
                for(String recipeToConsider : ingredientToRecipes.remove(recipe)) {
                    inDegree.put(recipeToConsider,inDegree.get(recipeToConsider)-1);
                    if(inDegree.get(recipeToConsider) == 0)
                    {
                        answer.add(recipeToConsider);
                    }
                }
            }
        }

        return answer;
    }
}
