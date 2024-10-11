package view;

import java.util.Arrays;

class CmdLine {
    private static final String PARAM_DELIMETER = " ";
    private String[] params;
    private Command cmd;
    private final String enteredLine;

    CmdLine(String enteredLine) {
        this.enteredLine = enteredLine;
        parseCmd(enteredLine);
        extractParams(enteredLine);
    }

    Command getCmd() {
        return cmd;
    }

    String getUserInput() {
        return enteredLine;
    }

    String getParameter(int index) {
        if (params == null) 
            return null;
        if (index >= params.length) 
            return null;
        return params[index];
    }

    private String removeExtraSpaces(String source) {
        if (source == null) 
            return source;
        String oneOrMoreOccurences = "+";
        return source.trim().replaceAll(PARAM_DELIMETER + oneOrMoreOccurences, PARAM_DELIMETER);
    }

    private void parseCmd(String enteredLine) {
        int cmdNameIndex = 0;
        try {
            String trimmed = removeExtraSpaces(enteredLine);
            if (trimmed == null) {
                cmd = Command.ILLEGAL_COMMAND;
                return;
            }
            String[] enteredTokens = trimmed.split(PARAM_DELIMETER);
            cmd = Command.valueOf(enteredTokens[cmdNameIndex].toUpperCase());
        } 
        catch (Exception failedToReadCmd) {
            cmd = Command.ILLEGAL_COMMAND;
        }
    }

    private void extractParams(String enteredLine) {
        if (enteredLine == null) {
            params = null;
            return;
        }
    
        String paramPartOfCmd = removeExtraSpaces(removeCmd(enteredLine));
        if (paramPartOfCmd == null) {
            params = null;
            return;
        }
    
        String[] tokens = paramPartOfCmd.split(PARAM_DELIMETER);
        switch (cmd) {
            case RENT:
            case RETURN:
                if (tokens.length > 1) {
                    params = new String[2];
                    params[0] = tokens[0];
                    params[1] = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));
                } 
                else 
                    params = new String[0];
                break;
    
            case ADDM:
                if (tokens.length >= 3) {
                    params = new String[3]; 
                    params[0] = String.join(" ", Arrays.copyOfRange(tokens, 0, tokens.length - 2)); 
                    params[1] = tokens[tokens.length - 2]; 
                    params[2] = tokens[tokens.length - 1]; 
                } 
                else 
                    params = new String[0];
                break;
    
            default:
                params = tokens;
                break;
        }
    }

    private String removeCmd(String enteredLine) {
        if (cmd == Command.ILLEGAL_COMMAND) {
            return enteredLine;
        }
        int indexAfterCmd = enteredLine.toUpperCase().indexOf(cmd.name()) + cmd.name().length();
        String withoutCmd = enteredLine.substring(indexAfterCmd, enteredLine.length());
        return withoutCmd.trim();
    }
}
