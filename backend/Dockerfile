# Python as language
ARG PYTHON_VERSION=3.12-slim
FROM python:${PYTHON_VERSION}

# Avoid Python writing .pyc files
ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1


# Install system dependencies (FFmpeg often needed for audio work)
RUN apt-get update && apt-get install -y --no-install-recommends \
    ffmpeg \
    && rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /bardrock_backend

# Copy the requirements file and install dependencies
COPY requirements.txt .

# Install dependencies (wheels cached)
RUN pip install --upgrade pip && \
    pip install -r requirements.txt

# Copy the rest of the backend code
COPY . .

# Expose port (FastAPI default)
EXPOSE 8000

# Command to run server
CMD ["uvicorn", "app:app", "--host", "0.0.0.0", "--port", "8000", "--reload"]