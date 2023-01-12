package dev.mrblackreal.fabricmod.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Environment(EnvType.SERVER)
public class Server implements DedicatedServerModInitializer {

    private static final Logger logger = LogManager.getLogger(Server.class.getSimpleName());

    @Override
    public void onInitializeServer() {


        logger.info("Initialized serverside mod!");
    }

    public static Logger getLogger() {
        return logger;
    }
}
