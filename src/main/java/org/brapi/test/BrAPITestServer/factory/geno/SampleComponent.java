package org.brapi.test.BrAPITestServer.factory.geno;

import io.swagger.model.Metadata;
import io.swagger.model.core.BatchTypes;
import io.swagger.model.geno.Sample;
import io.swagger.model.geno.SampleSearchRequest;
import org.brapi.test.BrAPITestServer.factory.BrAPIComponent;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.service.geno.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SampleComponent implements BrAPIComponent<Sample, SampleSearchRequest> {
    private final SampleService sampleService;

    @Autowired
    public SampleComponent(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @Override
    public List<Sample> findEntities(SampleSearchRequest request, Metadata metadata) {
        return sampleService.findSamples(request, metadata);
    }

    @Override
    public BatchTypes getBatchType() {
        return BatchTypes.SAMPLES;
    }


    @Override
    public List<String> collectDbIds(List<Sample> entities) {
        return entities.stream().map(Sample::getSampleDbId).collect(Collectors.toList());
    }

    @Override
    public void deleteBatchData(List<String> dbIds) {
        sampleService.deleteSampleBatch(dbIds);
    }

    @Override
    public void softDeleteBatchData(List<String> dbIds) {
        sampleService.softDeleteSampleBatch(dbIds);
    }
}
