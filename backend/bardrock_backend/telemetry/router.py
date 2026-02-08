from fastapi import APIRouter
from .model import Telemetry
from .collector import store_telemetry

telemetry_router = APIRouter(prefix="/telemetry")

@telemetry_router.post("")
async def receive_telemetry(sample: Telemetry):
    store_telemetry(sample)
    return {"received": True}
