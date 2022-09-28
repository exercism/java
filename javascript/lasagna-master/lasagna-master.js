/// <reference path="./global.d.ts" />
// @ts-check

export function cookingStatus(remainingTime) {
  if (remainingTime === 0) {
    return "Lasagna is done.";
  } else if (remainingTime > 0) {
    return "Not done, please wait.";
  }
  return "You forgot to set the timer.";
}

export function preparationTime(layers, timePerLayer=2) {
    return layers.length * timePerLayer;
}

export function quantities(ingredients) {
    let  [sauce, noodles] = [0,0]
    for (let ingredient of ingredients) {
        switch(ingredient) {
            case "sauce":
                sauce += 0.2;
                break;
            case "noodles":
                noodles += 50;
                break;
        }
    }
    return {sauce, noodles};
}

export function addSecretIngredient(friendsList, myList) {
    myList.push(friendsList[friendsList.length - 1])
}

export function scaleRecipe(recipe, factor) {
    let scaledRecipe = {};
    for (let ingredient in recipe) {
        scaledRecipe[ingredient] = (recipe[ingredient] * factor)/2;
    }
    return scaledRecipe;
}
