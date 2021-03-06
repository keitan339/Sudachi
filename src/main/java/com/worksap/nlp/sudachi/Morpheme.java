/*
 * Copyright (c) 2017 Works Applications Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.worksap.nlp.sudachi;

import java.util.List;

/**
 * A morpheme.
 */
public interface Morpheme {

    /**
     * Returns the start index of the morpheme.
     *
     * When the input text is normalized, some morphemes have
     * the same start index.
     *
     * @return the index of first character of the morpheme
     */
    public int begin();

    /**
     * Returns the offset after the last character of the morpheme.
     *
     * When the input text is normalized, some morphemes have
     * the same end index.
     *
     * @return the offset after the last character of the morpheme
     */
    public int end();

    /**
     * Returns the text of morpheme.
     *
     * When the input text is normalized, some morphemes have
     * the same surface.
     *
     * @return the text of morpheme
     */
    public String surface();

    /**
     * Returns the part of speech of the morpheme.
     *
     * @return the part of speech of the morpheme
     */
    public List<String> partOfSpeech();

    /**
     * Returns the ID of part of speech of the morpheme.
     *
     * @return the ID of part of speech of the morpheme
     */
    public short partOfSpeechId();

    /**
     * Returns the dictionary form of morpheme.
     *
     * 'Dictionary form' means a word's lemma and '終止形' in Japanese.
     *
     * @return the dictionary form of morpheme
     */
    public String dictionaryForm();

    /**
     * Returns the normalized form of morpheme.
     *
     * This method returns the form normalizing inconsistent spellings and
     * inflected forms.
     *
     * @return the normalized form of morpheme
     */
    public String normalizedForm();

    /**
     * Returns the reading form of morpheme.
     *
     * This method returns Japanese syllabaries 'フリガナ' in katakana.
     *
     * If the morpheme is OOV, it returns a empty string.
     *
     * @return the reading form of morpheme.
     */
    public String readingForm();

    /**
     * Split the morpheme in another splitting mode.
     *
     * If {@code mode} is the same with using in
     * {@link Tokenizer#tokenize(Tokenizer.SplitMode,String)} or no more
     * splitting, this method returns {@code this}.
     *
     * @param mode a mode of splitting
     * @return the list of splitted morphemes
     * @see Tokenizer#tokenize(Tokenizer.SplitMode,String)
     */
    public List<Morpheme> split(Tokenizer.SplitMode mode);

    /**
     * Returns whether the morpheme is out-of-vocabulary (OOV) or not.
     *
     * @return {@code true} if, and only if the morpheme is OOV
     */
    public boolean isOOV();

    /**
     * Returns the ID of the morpheme.
     *
     * The IDs change when the dictionaries are updated or
     * the combination of dictionaries changes.
     *
     * If the morpheme is OOV, it returns an undefined value.
     *
     * @return the word ID
     */
    public int getWordId();

    /**
     * Returns the ID of the dicitionary containing the morpheme.
     *
     * If the morpheme is in the system dictionary, it returns {@code 0}.
     * If the morpheme is OOV, it returns a negative value.
     *
     * @return the dictionary ID
     */
    public int getDictionaryId();
}
