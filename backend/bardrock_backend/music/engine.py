from ..telemetry.collector import telemetry_buffer
from .state import MusicState

def compute_music_state() -> MusicState:
    if not telemetry_buffer:
        return MusicState(mood="idle", track_id="bardrock:idle")

    latest = telemetry_buffer[-1]

    # Simple logic for now: low health → danger music
    if latest.health / latest.maxHealth < 0.3:
        return MusicState(mood="danger", track_id="bardrock:danger_theme")

    return MusicState(mood="calm", track_id="bardrock:calm_theme")
