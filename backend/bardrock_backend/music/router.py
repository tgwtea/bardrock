from fastapi import APIRouter
from .engine import compute_music_state

music_router = APIRouter(prefix="/music")

@music_router.get("/current")
async def get_current_music():
    return compute_music_state()
