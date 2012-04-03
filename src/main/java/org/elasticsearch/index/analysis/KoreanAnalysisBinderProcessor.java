/*
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 */

package org.elasticsearch.index.analysis;

/**
 *
 */
public class KoreanAnalysisBinderProcessor extends AnalysisModule.AnalysisBinderProcessor {

	@Override
	public void processAnalyzers(AnalyzersBindings analyzersBindings) {
		analyzersBindings.processAnalyzer("korean", KoreanAnalyzerProvider.class);
	}

	@Override
	public void processTokenizers(TokenizersBindings tokenizersBindings) {
		tokenizersBindings.processTokenizer("korean_tokenizer", KoreanTokenizerFactory.class);
	}

	@Override
	public void processTokenFilters(TokenFiltersBindings tokenFiltersBindings) {
		tokenFiltersBindings.processTokenFilter("korean_filter", KoreanFilterFactory.class);
	}

}
