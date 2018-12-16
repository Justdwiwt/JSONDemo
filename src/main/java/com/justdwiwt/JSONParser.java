package com.justdwiwt;

import com.justdwiwt.parser.Parser;
import com.justdwiwt.tokenizer.ReaderChar;
import com.justdwiwt.tokenizer.TokenList;
import com.justdwiwt.tokenizer.Tokenizer;

import java.io.IOException;
import java.io.StringReader;

class JSONParser {
    private Tokenizer tokenizer = new Tokenizer();

    private Parser parser = new Parser();

    Object fromJSON(String json) throws IOException {
        ReaderChar charReader = new ReaderChar(new StringReader(json));
        TokenList tokens = tokenizer.getTokenStream(charReader);
        return parser.parse(tokens);
    }
}
