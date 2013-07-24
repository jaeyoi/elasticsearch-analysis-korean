/*
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 */

package org.elasticsearch.plugin.analysis.korean;

import org.elasticsearch.common.collect.ImmutableList;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.kr.KoreanAnalysisBinderProcessor;
import org.elasticsearch.indices.analysis.kr.KoreanIndicesAnalysisModule;
import org.elasticsearch.plugins.AbstractPlugin;

import java.util.Collection;

/*
 *
 */
public class AnalysisKoreanPlugin extends AbstractPlugin {

	@Override
	public String name() {
		return "analysis-korean";
	}

	@Override
	public String description() {
		return "Korean analysis support";
	}

    @Override
    public Collection<Class<? extends Module>> modules() {
       return ImmutableList.<Class<? extends Module>>of(KoreanIndicesAnalysisModule.class);
    } 

	public void onModule(AnalysisModule module) {
		module.addProcessor(new KoreanAnalysisBinderProcessor());
	}

}
