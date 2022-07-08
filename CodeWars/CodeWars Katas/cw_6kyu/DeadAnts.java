package cw_6kyu;

/*
An orderly trail of ants is marching across the park picnic area.

It looks something like this:
..ant..ant.ant...ant.ant..ant.ant....ant..ant.ant.ant...ant..

But suddenly there is a rumour that a dropped chicken sandwich has been spotted on the ground ahead.
The ants surge forward! Oh No, it's an ant stampede!!

Some of the slower ants are trampled, and their poor little ant bodies are broken up into scattered bits.

The resulting carnage looks like this:
...ant...ant..nat.ant.t..ant...ant..ant..ant.anant..t

Can you find how many ants have died?
 */

public class DeadAnts {
    public static int deadAntCount(final String ants) {
        if (ants != null) {
            int countA = 0;
            int countN = 0;
            int countT = 0;
            String str = ants.replaceAll("ant","");
            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case 'a' -> countA++;
                    case 'n' -> countN++;
                    case 't' -> countT++;
                }
            }
            return Math.max(countA,Math.max(countN,countT));
        }
        return 0;
    }
}
