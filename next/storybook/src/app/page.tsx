import Button from '@/components/molecules/button/Button';

export default function RootPage() {
    return (
        <main className="m-4">
            <div>
                <Button type="submit" color="primary" size="medium">
                    Page Button
                </Button>
            </div>
        </main>
    );
}
