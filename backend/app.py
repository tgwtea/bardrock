from fastapi import FastAPI
from bardrock_backend.telemetry.router import telemetry_router
from bardrock_backend.music.router import music_router

app = FastAPI(title="BardRock Backend")

# Register module routers
app.include_router(telemetry_router)
app.include_router(music_router)

@app.get("/")
def root():
    return {"status": "BardRock backend running"}
