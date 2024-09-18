-- This migration adds a position field to list_item so that lists can be explicitly ordered.

-- Add position to list_item.
ALTER TABLE list_item
ADD COLUMN position INT NOT NULL DEFAULT 0;
