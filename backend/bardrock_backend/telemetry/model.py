
from pydantic import BaseModel

class Telemetry(BaseModel):
    dimension: str
    biome: str
    x: int
    y: int
    z: int
    health: float
    maxHealth: float
    timeOfDay: int
