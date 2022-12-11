package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/investment-module/api/v0/investments")
public class InvestRestApi {

    private final AssetCatalog assetCatalog;
    private final AccountManager accountManager;

    public InvestRestApi(AssetCatalog assetCatalog, AccountManager accountManager) {
        this.assetCatalog = assetCatalog;
        this.accountManager = accountManager;
    }

    public void investIntoAssetType(InvestCommandDto command) {
        accountManager.lock(command.amount());
        var allMatchingAssets = assetCatalog.allAssetsOfType(command.assetType());
        investIntoAssets(command.amount(), allMatchingAssets);
    }

    private void investIntoAssets(int amount, Set<Asset> allMatchingAssets) {
        // TODO: implement
        throw new UnsupportedOperationException("implement");
    }
}
