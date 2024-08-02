package io.xstefank;

import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command
public class CheckGrammarCommand implements Runnable {

    @CommandLine.Option(names = {"-l", "--language"}, description = "The language for which to check the grammar.", defaultValue = "Czech")
    String language;

    @CommandLine.Parameters(paramLabel = "<text>", description = "The text for which to check the grammar.")
    String text;

    @Inject
    GrammarCheckAiService grammarCheckAiService;

    @Override
    @ActivateRequestContext
    public void run() {
        System.out.println(grammarCheckAiService.fixGrammar(language, text));
    }
}
