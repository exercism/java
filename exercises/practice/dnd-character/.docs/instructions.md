# Instructions

# Instructions

In Dungeons & Dragons, each player starts by generating a character they can play with. This character has six primary abilities:

- Strength
- Dexterity
- Constitution
- Intelligence
- Wisdom
- Charisma

These abilities have scores determined randomly by rolling four 6-sided dice and recording the sum of the largest three dice. This process is repeated six times, once for each ability.

Your character's initial hitpoints are `10 + your character's constitution modifier`. The constitution modifier is found by subtracting 10 from the constitution score, dividing the result by 2, and rounding down.

Write a random character generator that follows the rules above.

## Example

Let's walk through the process of generating a character:

1. **Rolling for Strength**:
   - Dice rolls: 5, 3, 1, 6
   - Discard the lowest roll (1)
   - Sum the remaining rolls: 5 + 3 + 6 = 14
   - Assign 14 to Strength

2. **Rolling for Dexterity**:
   - Dice rolls: 3, 2, 5, 3
   - Discard the lowest roll (2)
   - Sum the remaining rolls: 3 + 5 + 3 = 11
   - Assign 11 to Dexterity

3. **Rolling for Constitution**:
   - Dice rolls: 1, 1, 1, 1
   - Discard the lowest roll (1, as all are the same)
   - Sum the remaining rolls: 1 + 1 + 1 = 3
   - Assign 3 to Constitution

4. **Rolling for Intelligence**:
   - Dice rolls: 2, 1, 6, 6
   - Discard the lowest roll (1)
   - Sum the remaining rolls: 2 + 6 + 6 = 14
   - Assign 14 to Intelligence

5. **Rolling for Wisdom**:
   - Dice rolls: 3, 5, 3, 4
   - Discard the lowest roll (3)
   - Sum the remaining rolls: 5 + 3 + 4 = 12
   - Assign 12 to Wisdom

6. **Rolling for Charisma**:
   - Dice rolls: 6, 6, 6, 6
   - Discard the lowest roll (6, as all are the same)
   - Sum the remaining rolls: 6 + 6 + 6 = 18
   - Assign 18 to Charisma

7. **Calculating Hitpoints**:
   - Constitution score is 3
   - Constitution modifier = (3 - 10) / 2 = -3.5 (rounded down to -4)
   - Hitpoints = 10 - 4 = 6

Your character now has the following abilities:
- Strength: 14
- Dexterity: 11
- Constitution: 3 (Modifier: -4)
- Intelligence: 14
- Wisdom: 12
- Charisma: 18
- Hitpoints: 6


## Notes

Most programming languages feature (pseudo-)random generators, but few programming languages are designed to roll dice.
One such language is [Troll][troll].

[dnd]: https://en.wikipedia.org/wiki/Dungeons_%26_Dragons
[troll]: https://di.ku.dk/Ansatte/?pure=da%2Fpublications%2Ftroll-a-language-for-specifying-dicerolls(84a45ff0-068b-11df-825d-000ea68e967b)%2Fexport.html
