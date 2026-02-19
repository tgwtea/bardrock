from collections import deque
from .model import Telemetry

# Store last 500 telemetry samples
telemetry_buffer = deque(maxlen=500)

def store_telemetry(sample: Telemetry):
    telemetry_buffer.append(sample)
