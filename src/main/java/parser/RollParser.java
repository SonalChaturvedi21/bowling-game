package parser;

import java.util.List;

import org.springframework.stereotype.Component;

import exception.ParsingException;
import model.Roll;

/*
 * Interface for the StringRollParser class to parse the input string of rolls and check if its valid
 * */

public interface RollParser {
    List<Roll> parse(Object rolls) throws ParsingException;
}
