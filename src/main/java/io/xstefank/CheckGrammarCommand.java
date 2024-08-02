package io.xstefank;

import io.quarkus.arc.Arc;
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
    GrammarCheckAIService grammarCheckAIService;

    @Override
    @ActivateRequestContext
    public void run() {
        System.out.println(getGrammarCheckAIService().fixGrammar(language, text));
    }

    private GrammarCheckAIService getGrammarCheckAIService() {
        // Fallback to programmatic lookup (needed for JBang)
        return grammarCheckAIService != null ? grammarCheckAIService : Arc.container().select(GrammarCheckAIService.class).get();
    }
}
