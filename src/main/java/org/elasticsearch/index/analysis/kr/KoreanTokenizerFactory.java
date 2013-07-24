/*
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 */

package org.elasticsearch.index.analysis.kr;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.kr.KoreanTokenizer;
import org.apache.lucene.util.Version;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;
import org.elasticsearch.index.settings.IndexSettings;

import java.io.Reader;

/**
 *
 */
public class KoreanTokenizerFactory extends AbstractTokenizerFactory {

	@Inject
	public KoreanTokenizerFactory(Index index, @IndexSettings Settings indexSettings, @Assisted String name, @Assisted Settings settings) {
		super(index, indexSettings, name, settings);
	}

	@Override
	public Tokenizer create(Reader reader) {
		return new KoreanTokenizer(version, reader);
	}

}
