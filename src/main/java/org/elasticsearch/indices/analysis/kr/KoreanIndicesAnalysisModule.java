/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 */

package org.elasticsearch.indices.analysis.kr;

import org.elasticsearch.common.inject.AbstractModule;

/**
 */
public class KoreanIndicesAnalysisModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(KoreanIndicesAnalysis.class).asEagerSingleton();
    }
}

