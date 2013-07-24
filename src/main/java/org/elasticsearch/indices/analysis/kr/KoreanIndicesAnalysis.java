/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 */

package org.elasticsearch.indices.analysis.kr;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.kr.KoreanAnalyzer;
import org.apache.lucene.analysis.kr.KoreanTokenizer;
import org.apache.lucene.analysis.kr.KoreanFilter;
import org.elasticsearch.common.component.AbstractComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.lucene.Lucene;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.analysis.AnalyzerScope;
import org.elasticsearch.index.analysis.PreBuiltAnalyzerProviderFactory;
import org.elasticsearch.index.analysis.PreBuiltTokenizerFactoryFactory;
import org.elasticsearch.index.analysis.PreBuiltTokenFilterFactoryFactory;
import org.elasticsearch.indices.analysis.IndicesAnalysisService;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;

import org.apache.lucene.analysis.TokenStream;

import java.io.IOException;
import java.io.Reader;

/**
 * Registers indices level analysis components so, if not explicitly configured, will be shared
 * among all indices.
 */
public class KoreanIndicesAnalysis extends AbstractComponent {

    @Inject
    public KoreanIndicesAnalysis(Settings settings, IndicesAnalysisService indicesAnalysisService) throws IOException {
        super(settings);

        indicesAnalysisService.analyzerProviderFactories().put("default", new PreBuiltAnalyzerProviderFactory("default", AnalyzerScope.INDICES, new KoreanAnalyzer(Lucene.ANALYZER_VERSION)));

        indicesAnalysisService.tokenizerFactories().put("korean_tokenizer", new PreBuiltTokenizerFactoryFactory(new TokenizerFactory() {
            @Override
            public String name() {
                return "korean_tokenizer";
            }

            @Override
            public Tokenizer create(Reader reader) {
                return new KoreanTokenizer(Lucene.ANALYZER_VERSION, reader);
            }
        }));

        indicesAnalysisService.tokenFilterFactories().put("korean_filter", new PreBuiltTokenFilterFactoryFactory(new TokenFilterFactory() {
            @Override public String name() {
                return "korean_filter";
            }

            @Override public TokenStream create(TokenStream tokenStream) {
                return new KoreanFilter(tokenStream);
            }
        }));
    }
}
