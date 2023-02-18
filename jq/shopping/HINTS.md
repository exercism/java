# Hints

## General

This exercise will get you two write `jq` filters for four tasks.
Because a `jq` program is a _single expression_, those four filters need to be joined with commas.

## 1. Extract the shopping list name

- The file contents can be accessed with the `.` filter.
- An object property can be accessed with dot-notation or bracket-notation.

## 2. Count how many ingredients are needed

- You need to output the length of an array.

## 3. How much sugar?

- You need to select the ingredient named "sugar".
- You need to access one of its properties.

## 4. Map the ingredients which can be substituted

- You need to concatenate two arrays.
- You need to select specific elements from the resulting array.
- You need to generate a key:value object for each of these elements.
- You need to merge these objects into a single object.