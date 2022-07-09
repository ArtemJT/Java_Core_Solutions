package cw_6kyu;

/*
You probably know the "like" system from Facebook and other pages.
People can "like" blog posts, pictures or other items.
We want to create the text that should be displayed next to such an item.

Implement the function which takes an array containing the names of people that like an item.
It must return the display text as shown in the examples:

[]                                -->  "no one likes this"
["Peter"]                         -->  "Peter likes this"
["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
Note: For 4 or more names, the number in "and 2 others" simply increases.
 */

class WhoLikesIt {
    public static String whoLikesIt(String... names) {
        if (names.length > 0) {
            switch (names.length) {
                case 1: return String.format("%s likes this", names[0]);
                case 2: return String.format("%s and %s like this", names[0], names[1]);
                case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
                default: {
                    int others = names.length -2;
                    return String.format("%s, %s and %d others like this", names[0], names[1], others);
                }
            }
        }
        return "no one likes this";
    }
}
