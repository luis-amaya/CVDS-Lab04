package hangman.setup.factoryMethod;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hangman.model.English;
import hangman.model.Language;
import hangman.model.GameScore;
import hangman.model.OriginalScore;
import hangman.setup.guice.HangmanFactoryServices;
import hangman.model.dictionary.EnglishDictionaryDataSource;
import hangman.model.dictionary.HangmanDictionary;
import hangman.view.HangmanPanel;
import hangman.view.HangmanStickmanPanel;

public class HangmanDefaultFactoryMethod extends HangmanFactoryMethod {
    @Override
    public Language createLanguage() {
        Injector injector = Guice.createInjector(new HangmanFactoryServices());
        return injector.getInstance(Language.class);
    }

    @Override
    public HangmanDictionary createDictionary() {
        Injector injector = Guice.createInjector(new HangmanFactoryServices());
        return injector.getInstance(HangmanDictionary.class);
    }

    @Override
    public HangmanPanel createHangmanPanel() {
        return new HangmanStickmanPanel();
    }

    @Override
    public GameScore createGameScore() {
        Injector injector = Guice.createInjector(new HangmanFactoryServices());
        return injector.getInstance(GameScore.class);
    }
}
