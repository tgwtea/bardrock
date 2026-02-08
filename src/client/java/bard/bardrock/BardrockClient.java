package bard.bardrock;

import bard.bardrock.telemetry.TelemetryCollector;
import bard.bardrock.telemetry.TelemetrySample;
import bard.bardrock.telemetry.TelemetrySender;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BardrockClient implements ClientModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("bardrock-client");

	private int tickCounter = 0;
	private final TelemetryCollector collector = new TelemetryCollector();
	private final TelemetrySender sender = new TelemetrySender();

	@Override
	public void onInitializeClient() {
		LOGGER.info("Bardrock (client) initialized");
		ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
	}

	/*
	 * This method is called at the end of each client tick.
	 * At every tick, we collect telemetry data and send it if enough time has passed.
	 */
	private void onClientTick(MinecraftClient client) {
		if (client.player == null || client.world == null) {
			return; // Wait until the player and world are initialized
		}

		tickCounter++;

		if (tickCounter % 20 != 0) { // Every second (20 ticks)
			return;
		}

		TelemetrySample sample = collector.collect(client);
		if (sample != null) {
			sender.queueSend(sample);
		}



	}
}