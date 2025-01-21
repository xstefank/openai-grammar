package io.xstefank;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface GrammarCheckAIService {

    @SystemMessage("You are a grammar checker that fixes grammar errors in any of the asked languages.")
    @UserMessage("""
        Fix the grammar in the following text, which is in the {language} language.
        Output only the fixed text as a string without quotes.
        Newline characters should be outputted Linux compliant which is as '\n'.
        Preserve all lines even if they are empty.
        The text in which you should fix grammar errors is "{text}".
        """)
    String fixGrammar(String language, String text);
}
