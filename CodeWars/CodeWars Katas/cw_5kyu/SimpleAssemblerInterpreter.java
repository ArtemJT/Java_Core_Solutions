package cw_5kyu;

/*
This is the first part of this kata series. Second part is here.

We want to create a simple interpreter of assembler which will support the following instructions:

mov x y - copies y (either a constant value or the content of a register) into register x
inc x - increases the content of the register x by one
dec x - decreases the content of the register x by one
jnz x y - jumps to an instruction y steps away (positive means forward, negative means backward, y can be a register or a constant),
but only if x (a constant or a register) is not zero
Register names are alphabetical (letters only). Constants are always integers (positive or negative).

Note: the jnz instruction moves relative to itself. For example, an offset of -1 would continue at the previous instruction,
while an offset of 2 would skip over the next instruction.

The function will take an input list with the sequence of the program instructions and will execute them.
The program ends when there are no more instructions to execute, then it returns a dictionary (a table in COBOL)
with the contents of the registers.

Also, every inc/dec/jnz on a register will always be preceeded by a mov on the register first,
so you don't need to worry about uninitialized registers.

Example
SimpleAssembler.interpret(new String[]{"mov a 5","inc a","dec a","dec a","jnz a -1","inc a"});

''' visualized:
mov a 5
inc a
dec a
dec a
jnz a -1
inc a
''''
The above code will:

set register a to 5,
increase its value by 1,
decrease its value by 2,
then decrease its value until it is zero (jnz a -1 jumps to the previous instruction if a is not zero)
and then increase its value by 1, leaving register a at 1
So, the function should return

{a=1}
```ocaml simple_assembler ["mov a 5"; "inc a"; "dec a"; "dec a"; "jnz a -1"; "inc a"]

''' visualized: mov a 5 inc a dec a dec a jnz a -1 inc a '''

This kata is based on the Advent of Code 2016 - day 12
 */

import java.util.HashMap;
import java.util.Map;

public class SimpleAssemblerInterpreter {
    private static Map<String, Integer> resultMap;

    public static Map<String, Integer> interpret(String[] program){
        resultMap = new HashMap<>();
        int i = 0;
        while (i < program.length) {
            String[] s = program[i].split(" ");
            switch (s[0]) {
                case "mov" -> {
                    mov(s[1], s[2]);
                    i++;
                }
                case "inc" -> {
                    inc(s[1]);
                    i++;
                }
                case "dec" -> {
                    dec(s[1]);
                    i++;
                }
                default -> {
                    int goToIndex = i + Integer.parseInt(s[2]);
                    if (goToIndex < 0 || goToIndex > program.length) {
                        return resultMap;
                    }
                    try {
                        i = Integer.parseInt(s[1]) != 0 ? goToIndex : (i + 1);
                    } catch (NumberFormatException e) {
                        i = resultMap.get(s[1]) != 0 ? goToIndex : (i + 1);
                    }
                }
            }
        }
        return resultMap;
    }

    private static void mov(String key, String value) {
        try {
            resultMap.put(key, Integer.parseInt(value));
        } catch (NumberFormatException e) {
            resultMap.put(key, resultMap.get(value));
        }
    }

    private static void inc(String key) {
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            if (entry.getKey().equals(key)) {
                int newValue = resultMap.get(key) + 1;
                entry.setValue(newValue);
            }
        }
    }

    private static void dec(String key) {
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            if (entry.getKey().equals(key)) {
                int newValue = resultMap.get(key) - 1;
                entry.setValue(newValue);
            }
        }
    }
}
