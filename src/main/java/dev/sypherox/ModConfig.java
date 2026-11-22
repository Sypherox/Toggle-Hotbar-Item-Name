package dev.sypherox;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(HotbarItemNameClient.MOD_ID);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE =
            FabricLoader.getInstance().getConfigDir().resolve(HotbarItemNameClient.MOD_ID + ".json");

    private static ModConfig instance = new ModConfig();

    public boolean showHeldItemName = false;

    public static ModConfig get() {
        return instance;
    }

    public static void load() {
        if (!Files.exists(FILE)) {
            save();
            return;
        }
        try (Reader reader = Files.newBufferedReader(FILE)) {
            ModConfig loaded = GSON.fromJson(reader, ModConfig.class);
            if (loaded != null) {
                instance = loaded;
            }
        } catch (Exception e) {
            LOGGER.error("Could not load config, using default values", e);
        }
    }

    public static void save() {
        try (Writer writer = Files.newBufferedWriter(FILE)) {
            GSON.toJson(instance, writer);
        } catch (Exception e) {
            LOGGER.error("Could not save config", e);
        }
    }
}
