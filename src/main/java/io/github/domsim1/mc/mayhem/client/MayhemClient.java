package io.github.domsim1.mc.mayhem.client;

import io.github.domsim1.mc.mayhem.entity.MayhemEntityType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class MayhemClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MayhemEntityType.registerEntityRenders();
    }
}
