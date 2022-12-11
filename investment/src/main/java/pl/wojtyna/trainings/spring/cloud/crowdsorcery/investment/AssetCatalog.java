package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investment;

import java.util.Set;

public interface AssetCatalog {

    Set<Asset> allAssetsOfType(String assetType);
}
