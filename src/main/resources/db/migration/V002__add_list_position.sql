-- This migration adds a position field to list_item so that lists can be explicitly ordered.

-- Add position to list_item.
ALTER TABLE list_item
ADD COLUMN position INT NOT NULL DEFAULT 0;
-- Add an index on the position column
CREATE INDEX idx_list_item_position ON list_item(position);
-- Add a composite index on list_id and position for better performance when querying items within a specific list
CREATE INDEX idx_list_item_list_position ON list_item(list_id, position);
