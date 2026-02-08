from pydantic import BaseModel

class MusicState(BaseModel):
    mood: str
    track_id: str
