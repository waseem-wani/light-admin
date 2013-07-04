package org.lightadmin.core.config.domain.filter;

import org.lightadmin.core.config.domain.renderer.Renderer;
import org.lightadmin.core.config.domain.unit.DomainTypeConfigurationUnitBuilder;

import java.util.Set;

import static com.google.common.collect.Sets.newLinkedHashSet;

public class DefaultFiltersConfigurationUnitBuilder extends DomainTypeConfigurationUnitBuilder<FiltersConfigurationUnit> implements FiltersConfigurationUnitBuilder {

    private final Set<FilterMetadata> filtersMetadata = newLinkedHashSet();

    public DefaultFiltersConfigurationUnitBuilder(final Class<?> domainType) {
        super(domainType);
    }

    @Override
    public FiltersConfigurationUnitBuilder filter(final String filterName, String fieldName) {
        filtersMetadata.add(FilterMetadataUtils.filter(filterName, fieldName));
        return this;
    }

    @Override
    public FiltersConfigurationUnitBuilder renderer(final Renderer renderer) {
        return this;
    }

    @Override
    public FiltersConfigurationUnit build() {
        return new DefaultFiltersConfigurationUnit(getDomainType(), filtersMetadata);
    }
}